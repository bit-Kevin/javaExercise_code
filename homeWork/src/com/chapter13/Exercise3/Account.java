package com.chapter13.Exercise3;

public class Account {
    private String name;
    private String psw;
    private String Email;

    public void setName(String name) {
        if (!(name.length()>=2&&name.length()<=4)){
            throw new RuntimeException("用户名长度需要4~2之间");
        }
        this.name = name;
    }

    public void setPsw(String psw) {
        if (!(psw.length()==6)){
            throw new RuntimeException("密码长度不为6");
        }
        Integer.parseInt(psw);
        this.psw = psw;
    }

    public void setEmail(String email) {
       int i= email.indexOf('@');
       if (i==-1){
           throw new RuntimeException("格式错误，缺少@");
       }
       int j= email.indexOf('.');
        if (j==-1){
            throw new RuntimeException("格式错误，缺少.");
        }
        if (!(i<j)){
            throw new RuntimeException("格式错误，@与.顺序不对");
        }
        Email = email;
    }

    public Account(String name, String psw, String email) {
        setName(name);
        setPsw(psw);
        setEmail(email);
    }

    @Override
    public String toString() {
        return "name=" + name + '\n' + "psw=" + psw + '\n' + "Email=" + Email ;
    }

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public String getEmail() {
        return Email;
    }
}
