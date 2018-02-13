package cn.pjmike.Blog.domain;

/**
 * 用户类
 *
 * @author pjmike
 * @create 2018-02-04 11:17
 **/
public class User {
    private Long id;
    private String username;
    private String password;
    /**
     * 用户头像
     */
    private String icon;
    /**
     * 用户性别
     */
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
