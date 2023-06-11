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
public class Nature10 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "nature_id", type = IdType.AUTO)
    private Integer natureId;

    /**
     * 性格的标题
     */
    private String natureTittle;

    /**
     * 性格介绍
     */
    private String natureDesc;

    public Integer getNatureId() {

        return natureId;
    }

    public void setNatureId(Integer natureId) {

        this.natureId = natureId;
    }
    public String getNatureTittle() {

        return natureTittle;
    }

    public void setNatureTittle(String natureTittle) {

        this.natureTittle = natureTittle;
    }
    public String getNatureDesc() {

        return natureDesc;
    }

    public void setNatureDesc(String natureDesc) {

        this.natureDesc = natureDesc;
    }

    @Override
    public String toString() {
        return "Nature10{" +
            "natureId=" + natureId +
            ", natureTittle=" + natureTittle +
            ", natureDesc=" + natureDesc +
        "}";
    }
}
