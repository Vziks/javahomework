package info.vziks.exam.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDateTime;

public class LauchExternalizable implements Externalizable {

    private int count;
    private LocalDateTime lastLaunch;
    transient private String name = "Launch";
    static private String stat = "stat";
    private String user;
//    private String user1;
//    private static final long serialVersionUID = 1L;


    public boolean isLastLaunch() {
        return count == 0 && lastLaunch == null;
    }

    public void update() {
        setCount(++count);
        setLastLaunch(LocalDateTime.now());
        setUser(System.getProperty("user.name"));
    }

    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @param out the stream to write the object to
     * @throws IOException Includes any I/O exceptions that may occur
     * @serialData Overriding methods should use this tag to describe
     * the data layout of this Externalizable object.
     * List the sequence of element types and, if possible,
     * relate the element to a public/protected field and/or
     * method of this Externalizable class.
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.getCount());
        out.writeObject(this.getLastLaunch());
        out.writeObject(this.getName());
        out.writeObject(this.getUser());
    }

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param in the stream to read data from in order to restore the object
     * @throws IOException            if I/O errors occur
     * @throws ClassNotFoundException If the class for an object being
     *                                restored cannot be found.
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        count = in.readInt();
        lastLaunch = (LocalDateTime) in.readObject();
        name = (String) in.readObject();
        user = (String) in.readObject();
    }

    public int getCount() {
        return count;
    }

    public LauchExternalizable setCount(int count) {
        this.count = count;
        return this;
    }

    public LocalDateTime getLastLaunch() {
        return lastLaunch;
    }

    public LauchExternalizable setLastLaunch(LocalDateTime lastLaunch) {
        this.lastLaunch = lastLaunch;
        return this;
    }

    public String getName() {
        return name;
    }

    public LauchExternalizable setName(String name) {
        this.name = name;
        return this;
    }

    public static String getStat() {
        return stat;
    }

    public static void setStat(String stat) {
        LauchExternalizable.stat = stat;
    }

    public String getUser() {
        return user;
    }

    public LauchExternalizable setUser(String user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LauchExternalizable{");
        sb.append("count=").append(count);
        sb.append(", lastLaunch=").append(lastLaunch);
        sb.append(", name='").append(name).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
