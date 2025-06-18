package ai.idealistic.vacan.compatibility.b;

import ai.idealistic.vacan.api.Permission;
import org.bukkit.entity.Player;

public class a {
   public static boolean c(Player var0) {
      return c.d(var0) || !ai.idealistic.vacan.compatibility.b.a.b.a(var0) && b.a(var0.getUniqueId(), var0.getName()) || ai.idealistic.vacan.functionality.server.a.iZ.i("Important.bedrock_client_permission") && ai.idealistic.vacan.functionality.server.b.b(var0, Permission.BEDROCK);
   }
}
