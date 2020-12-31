package cn.com.codingce.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzMa
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ze_download")
@ApiModel(value="Download对象", description="")
public class Download implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源名")
    private String dname;

    @ApiModelProperty(value = "资源链接")
    private String ddesc;

    @ApiModelProperty(value = "提取码")
    private String dcode;


}
