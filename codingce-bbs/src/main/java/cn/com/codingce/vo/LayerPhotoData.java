package cn.com.codingce.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  vo
 * </p>
 *
 * @author Ma Xinze
 * @since 2021-1-1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LayerPhotoData {

    @ApiModelProperty(value = "图片名")
    private String alt;

    @ApiModelProperty(value = "图片id")
    private int pid;

    @ApiModelProperty(value = "原图地址")
    private String src;

    @ApiModelProperty(value = "缩略图地址")
    private String thumb;

}
