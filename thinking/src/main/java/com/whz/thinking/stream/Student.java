/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年4月4日 下午10:34:59 
 * @version V1.0 
 * @Title: Student.java  
 */
package com.whz.thinking.stream;

/** 
 * @Description: 学生类实体
 * @author hongzhi wang
 * @date 2019年4月4日 下午10:34:59 
 * @ClassName: Student
 *  
 */
public class Student
{
    private String name;
    
    private Double score;
    
    public Student(String name, Double score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getScore()
    {
        return score;
    }

    public void setScore(Double score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [name=");
        builder.append(name);
        builder.append(", score=");
        builder.append(score);
        builder.append(']');
        return builder.toString();
    }
}
