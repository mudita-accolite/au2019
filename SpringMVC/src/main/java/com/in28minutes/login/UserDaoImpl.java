package com.in28minutes.login;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.sql.DataSource;
import javax.xml.ws.Service.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {
	static HashMap<Token, Integer> countErrorPassword = new HashMap();
	public static HashMap<String, Timestamp> defaulters = new HashMap();

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {

		String sql = "insert into users values(?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	}

	public User validateUser(Login login) {

		String sql = "select * from users";

		String sql1 = "select * from users where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";
		List<User> users1 = jdbcTemplate.query(sql1, new UserMapper());
		if (users1.size() > 0)
			return users1.get(0);

		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		for (User u : users) {
			Token entry = new Token(u.getUsername(), u.getPassword());
			countErrorPassword.put(entry, 0);

		}

		String inputName = login.getUsername();
		String inputPassword = login.getPassword();

		boolean a = defaulters.containsKey(inputName);

		if (defaulters.containsKey(inputName)) {
			Date date = new Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			Timestamp ts2 = defaulters.get(inputName);
			long diffMs = ts.getTime() - ts2.getTime();
			long diffSec = diffMs / 1000;
			long min = diffSec / 60;
			if (min < 5) {
				String message = "Waiting time not over yet : time passed is " + min;
				return null;
			} else {
				defaulters.remove(inputName);
			}
		}
		String message;
		Model m;

		for (Map.Entry<Token, Integer> entry : countErrorPassword.entrySet()) {
			Token u = entry.getKey();
			// System.out.println(u.getName());
			// System.out.println("abc100");
			if (u.getName().equals(inputName)) {

				if (u.getPass().equals(inputPassword)) {
					message = "Success";
					// m.addAttribute("message", message);
					countErrorPassword.replace(u, 0);
					return users.get(0);
				} else {
					System.out.println("Password error!");
					String msg;
					// m.addAttribute("message", message);
					int count = countErrorPassword.get(u);
					count++;
					countErrorPassword.replace(u, count);
					if (count >= 3) {
						Date date = new Date();
						long time = date.getTime();
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						defaulters.put(inputName, ts);
//					System.out.println("you have entered wrong password, wait for 5 minutes then login!");
						// m.addAttribute("msg", msg);
						countErrorPassword.replace(u, 0);
						return null;
					} else if (count == 2) {
						msg = "username or password is wrong, you can try only one more time!";
						// m.addAttribute("msg", msg);
						return null;
					} else if (count == 1) {
						msg = "you can try only two more time!";
						// m.addAttribute("msg", msg);
						return null;
					}
				}
			} else {
				// message="Username not found!";
				String msg = " Username not found !!! Please register first";
				// m.addAttribute("msg", msg);
				// m.addAttribute("message", message);
				return null;
			}
		}
		return users.get(0);
	}

}

class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getInt("phone"));

		return user;
	}
}
