package my.work.multitenencydatabase.config;

public class TenantContextHolder {

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setContextHolder(String tenantId) {
        contextHolder.set(tenantId);
    }

    public static String getTenantId() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }
}
