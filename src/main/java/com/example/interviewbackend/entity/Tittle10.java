package com.example.interviewbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jason
 * @since 2023-04-26
 */
public class Tittle10 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tittle_id", type = IdType.AUTO)
    private Integer tittleId;

    /**
     * 题目的问题
     */
    private String tittleQuestion;

    /**
     * 题目的A选项
     */
    private String tittleA;

    /**
     * 题目的B选项
     */
    private String tittleB;

    /**
     * 题目的C选项
     */
    private String tittleC;

    /**
     * 题目的D选项
     */
    private String tittleD;

    /**
     * 题目的E选项
     */
    private String tittleE;

    /**
     * 题目的F选项
     */
    private String tittleF;

    /**
     * 选项对应的分数，一共是6个数字构成的字符串，数字最高时7最小是1
     */
    private String tittleScore;

    public Integer getTittleId() {
        return tittleId;
    }

    public void setTittleId(Integer tittleId) {
        this.tittleId = tittleId;
    }
    public String getTittleQuestion() {
        return tittleQuestion;
    }

    public void setTittleQuestion(String tittleQuestion) {
        this.tittleQuestion = tittleQuestion;
    }
    public String getTittleA() {
        return tittleA;
    }

    public void setTittleA(String tittleA) {
        this.tittleA = tittleA;
    }
    public String getTittleB() {
        return tittleB;
    }

    public void setTittleB(String tittleB) {
        this.tittleB = tittleB;
    }
    public String getTittleC() {
        return tittleC;
    }

    public void setTittleC(String tittleC) {
        this.tittleC = tittleC;
    }
    public String getTittleD() {
        return tittleD;
    }

    public void setTittleD(String tittleD) {
        this.tittleD = tittleD;
    }
    public String getTittleE() {
        return tittleE;
    }

    public void setTittleE(String tittleE) {
        this.tittleE = tittleE;
    }
    public String getTittleF() {
        return tittleF;
    }

    public void setTittleF(String tittleF) {
        this.tittleF = tittleF;
    }
    public String getTittleScore() {
        return tittleScore;
    }

    public void setTittleScore(String tittleScore) {
        this.tittleScore = tittleScore;
    }

    @Override
    public String toString() {
        return "Tittle10{" +
            "tittleId=" + tittleId +
            ", tittleQuestion=" + tittleQuestion +
            ", tittleA=" + tittleA +
            ", tittleB=" + tittleB +
            ", tittleC=" + tittleC +
            ", tittleD=" + tittleD +
            ", tittleE=" + tittleE +
            ", tittleF=" + tittleF +
            ", tittleScore=" + tittleScore +
        "}";
    }
}
