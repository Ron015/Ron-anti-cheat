package ai.idealistic.vacan.api;

public enum Permission {
   CONDITION,
   WAVE,
   ADMIN,
   RELOAD,
   KICK,
   BYPASS,
   MANAGE,
   INFO,
   WARN,
   USE_BYPASS,
   NOTIFICATIONS,
   BEDROCK;

   private final String key = "vacan." + this.name().toLowerCase();

   public String getKey() {
      return this.key;
   }

   // $FF: synthetic method
   private static Permission[] $values() {
      return new Permission[]{CONDITION, WAVE, ADMIN, RELOAD, KICK, BYPASS, MANAGE, INFO, WARN, USE_BYPASS, NOTIFICATIONS, BEDROCK};
   }
}
