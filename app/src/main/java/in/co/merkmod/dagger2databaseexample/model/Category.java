package in.co.merkmod.dagger2databaseexample.model;

/**
 * Created by rkodekar on 8/21/16.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Category {

    @SerializedName("MainGroup_Id")
    @Expose
    private String mainGroupId;
    @SerializedName("MainGroup_Name")
    @Expose
    private String mainGroupName;
    @SerializedName("MainGroup_SortNo")
    @Expose
    private String mainGroupSortNo;
    @SerializedName("MainGroup_Template")
    @Expose
    private Object mainGroupTemplate;
    @SerializedName("MainGroup_Remarks")
    @Expose
    private Object mainGroupRemarks;
    @SerializedName("Active")
    @Expose
    private String active;
    @SerializedName("MainGroup_ImgPath")
    @Expose
    private String mainGroupImgPath;

    /**
     *
     * @return
     * The mainGroupId
     */
    public String getMainGroupId() {
        return mainGroupId;
    }

    /**
     *
     * @param mainGroupId
     * The MainGroup_Id
     */
    public void setMainGroupId(String mainGroupId) {
        this.mainGroupId = mainGroupId;
    }

    /**
     *
     * @return
     * The mainGroupName
     */
    public String getMainGroupName() {
        return mainGroupName;
    }

    /**
     *
     * @param mainGroupName
     * The MainGroup_Name
     */
    public void setMainGroupName(String mainGroupName) {
        this.mainGroupName = mainGroupName;
    }

    /**
     *
     * @return
     * The mainGroupSortNo
     */
    public String getMainGroupSortNo() {
        return mainGroupSortNo;
    }

    /**
     *
     * @param mainGroupSortNo
     * The MainGroup_SortNo
     */
    public void setMainGroupSortNo(String mainGroupSortNo) {
        this.mainGroupSortNo = mainGroupSortNo;
    }

    /**
     *
     * @return
     * The mainGroupTemplate
     */
    public Object getMainGroupTemplate() {
        return mainGroupTemplate;
    }

    /**
     *
     * @param mainGroupTemplate
     * The MainGroup_Template
     */
    public void setMainGroupTemplate(Object mainGroupTemplate) {
        this.mainGroupTemplate = mainGroupTemplate;
    }

    /**
     *
     * @return
     * The mainGroupRemarks
     */
    public Object getMainGroupRemarks() {
        return mainGroupRemarks;
    }

    /**
     *
     * @param mainGroupRemarks
     * The MainGroup_Remarks
     */
    public void setMainGroupRemarks(Object mainGroupRemarks) {
        this.mainGroupRemarks = mainGroupRemarks;
    }

    /**
     *
     * @return
     * The active
     */
    public String getActive() {
        return active;
    }

    /**
     *
     * @param active
     * The Active
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     *
     * @return
     * The mainGroupImgPath
     */
    public String getMainGroupImgPath() {
        return mainGroupImgPath;
    }

    /**
     *
     * @param mainGroupImgPath
     * The MainGroup_ImgPath
     */
    public void setMainGroupImgPath(String mainGroupImgPath) {
        this.mainGroupImgPath = mainGroupImgPath;
    }

}
