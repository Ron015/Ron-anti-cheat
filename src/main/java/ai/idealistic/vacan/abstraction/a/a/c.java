package ai.idealistic.vacan.abstraction.a.a;

import java.util.Collection;
import java.util.Iterator;

public class c extends ai.idealistic.vacan.abstraction.a.a {
   public static final String eK = "Important.server_name";

   public c() {
      super("settings");
   }

   public void ay() {
      this.b("Logs.log_file", true);
      this.b("Logs.log_console", true);
      this.b("Notifications.individual_only_notifications", false);
      this.b("Notifications.enable_notifications_on_login", true);
      this.b("Notifications.awareness_notifications", true);
      this.b("Notifications.message_clickable_command", "/teleport {player}");
      this.b("Important.op_bypass", false);
      this.b("Important.server_name", "");
      this.b("Important.bedrock_client_permission", false);
      this.b("Important.bedrock_player_prefix", ".");
      this.b("Important.enable_developer_api", true);
      this.b("Important.enable_npc", false);
      this.b("Important.enable_watermark", true);
      this.b("Purchases.paypal_email", "");
      this.b("Purchases.patreon_full_name", "");
      this.b("Purchases.builtbybit_user_url", "");
      if (!this.h("Purchases.opt_out_from_subscriptions")) {
         ai.idealistic.vacan.functionality.server.c.jj.g(() -> {
            if (!ai.idealistic.vacan.functionality.connection.b.eK()) {
               this.b("Purchases.opt_out_from_subscriptions", false);
            }

         });
      }

      this.b("Detections.ground_teleport_on_detection", true);
      this.b("Detections.damage_on_detection", false);
      this.b("Discord.webhook_hex_color", "4caf50");
      this.b("Discord.checks_webhook_url", "");
   }

   public void c(ai.idealistic.vacan.abstraction.f.c var1) {
      if (this.i("Notifications.enable_notifications_on_login") && ai.idealistic.vacan.functionality.c.c.s(var1) && !ai.idealistic.vacan.functionality.c.c.q(var1)) {
         ai.idealistic.vacan.functionality.c.c.c(var1, Integer.MIN_VALUE);
      }

   }

   public void aL() {
      Collection var1 = ai.idealistic.vacan.functionality.server.c.fc();
      if (!var1.isEmpty()) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var3 = (ai.idealistic.vacan.abstraction.f.c)var2.next();
            this.c(var3);
         }
      }

   }
}
