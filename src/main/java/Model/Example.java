package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("worth")
    @Expose
    private String worth;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("open_giveaway_url")
    @Expose
    private String openGiveawayUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("platforms")
    @Expose
    private String platforms;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("users")
    @Expose
    private Integer users;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gamerpower_url")
    @Expose
    private String gamerpowerUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getOpenGiveawayUrl() {
        return openGiveawayUrl;
    }

    public void setOpenGiveawayUrl(String openGiveawayUrl) {
        this.openGiveawayUrl = openGiveawayUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGamerpowerUrl() {
        return gamerpowerUrl;
    }

    public void setGamerpowerUrl(String gamerpowerUrl) {
        this.gamerpowerUrl = gamerpowerUrl;
    }

}
