
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Scheme {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("size")
    @Expose
    public Integer size;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(size).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Scheme) == false) {
            return false;
        }
        Scheme rhs = ((Scheme) other);
        return new EqualsBuilder().append(id, rhs.id).append(size, rhs.size).isEquals();
    }

}
