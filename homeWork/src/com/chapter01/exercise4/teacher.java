package com.chapter01.exercise4;

public class teacher extends person {
    private int workAge;
    private  String like;
    public String teach(){
        return "\n我承诺，我会认真教课";
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String play() {
        return super.play()+like;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "workAge=" + workAge +
                ", like='" + like + '\'' +
                '}'+super.toString();
    }

    public teacher(String name, int age, String sex, int workAge, String like) {
        super(name, age, sex);
        this.workAge = workAge;
        this.like = like;
    }
}
