package ai.idealistic.vacan.utils.minecraft.c;

import ai.idealistic.vacan.Register;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class c {
   private static final String name = "BungeeCord";

   public static void fG() {
      if (!Bukkit.getOnlineMode()) {
         Register.plugin.getServer().getMessenger().registerOutgoingPluginChannel(Register.plugin, "BungeeCord");
      }

   }

   public static void fH() {
      Register.plugin.getServer().getMessenger().unregisterIncomingPluginChannel(Register.plugin);
   }

   public static boolean d(Player var0, String var1) {
      if (!Bukkit.getOnlineMode() && !ai.idealistic.vacan.compatibility.b.a.b.a(var0)) {
         boolean var2 = var0 == null;
         if (var2 || !var0.isOp()) {
            Set var3 = ai.idealistic.vacan.functionality.server.c.fd();
            Iterator var4;
            if (!var2) {
               var4 = var3.iterator();

               while(var4.hasNext()) {
                  UUID var5 = (UUID)((Entry)var4.next()).getKey();
                  if (var0.getUniqueId().equals(var5)) {
                     var4.remove();
                     break;
                  }
               }
            }

            if (!var3.isEmpty()) {
               var4 = var3.iterator();

               while(var4.hasNext()) {
                  Entry var10 = (Entry)var4.next();
                  ai.idealistic.vacan.abstraction.f.c var6 = (ai.idealistic.vacan.abstraction.f.c)var10.getValue();
                  if (var6.bC().isOp()) {
                     var0 = var6.bC();
                     break;
                  }

                  if (ai.idealistic.vacan.functionality.server.b.h(var6.bC())) {
                     var0 = var6.bC();
                  }
               }
            }
         }

         if (var0 != null) {
            ByteArrayOutputStream var8 = new ByteArrayOutputStream();
            DataOutputStream var9 = new DataOutputStream(var8);

            try {
               var9.writeUTF("Message");
               var9.writeUTF("ALL");
               var9.writeUTF("/" + var1);
               var0.sendPluginMessage(Register.plugin, "BungeeCord", var8.toByteArray());
               return true;
            } catch (Exception var7) {
               ai.idealistic.vacan.functionality.c.a.N("BungeeCord Command Failed: \nPlayer: " + var0.getName() + "\nCommand: " + var1);
               var7.printStackTrace();
            }
         } else {
            ai.idealistic.vacan.functionality.c.a.N("BungeeCord Command Failed: \nPlayer: NULL\nCommand: " + var1);
         }
      } else {
         ai.idealistic.vacan.functionality.c.a.N("BungeeCord Command Failed: \nServer: Not-Proxy-Supported\nCommand: " + var1);
      }

      return false;
   }
}
