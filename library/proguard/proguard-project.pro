-keepparameternames

-keep public interface com.thinkincode.utils.** {
    <methods>;
}

-keep public class com.thinkincode.utils.** {
    public <init>(...);
    public <fields>;
    public static <fields>;
    public <methods>;
    public static <methods>;
}

-keep public enum com.thinkincode.utils.** {
    public <init>(...);
    public <fields>;
    public static <fields>;
    public <methods>;
    public static <methods>;
}
