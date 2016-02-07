package paulacr.net.intents;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by paularosa on 1/21/16.
 */
public class Item implements Parcelable {

    private Integer icon;
    private String title;
    private Integer color;
    private String tag;

    public Item(Integer icon, String title, String tag, Integer color){
        this.icon = icon;
        this.title = title;
        this.color = color;
        this.tag = tag;
    }

    protected Item(Parcel in) {
        title = in.readString();
        icon = in.readInt();
        color = in.readInt();
        tag = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(icon);
        dest.writeInt(color);
        dest.writeString(tag);
    }
}
