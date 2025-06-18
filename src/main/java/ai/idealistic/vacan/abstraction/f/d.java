package ai.idealistic.vacan.abstraction.f;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import java.util.Collection;
import java.util.Iterator;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class d {
   private final c hi;
   private long hj;
   private long hk;

   public d(c var1) {
      this.hi = var1;
   }

   public boolean a(CommandSender var1, String var2) {
      if (this.hj < System.currentTimeMillis()) {
         this.hj = System.currentTimeMillis() + 1000L;
         Player var3 = this.hi.bC();
         String var4 = var1 instanceof ConsoleCommandSender ? ai.idealistic.vacan.functionality.server.a.jb.m("console_name") : var1.getName();
         String var5 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var3, ai.idealistic.vacan.functionality.server.a.jb.m("kick_reason").replace("{reason}", var2).replace("{punisher}", var4), (CheckEnums.HackType)null);
         String var6 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var3, ai.idealistic.vacan.functionality.server.a.jb.m("kick_broadcast_message").replace("{reason}", var2).replace("{punisher}", var4), (CheckEnums.HackType)null);
         Collection var7 = ai.idealistic.vacan.functionality.server.c.fc();
         if (!var7.isEmpty()) {
            Iterator var8 = var7.iterator();

            while(var8.hasNext()) {
               c var9 = (c)var8.next();
               if (ai.idealistic.vacan.functionality.c.c.s(var9)) {
                  var9.bC().sendMessage(var6);
               }
            }
         }

         ai.idealistic.vacan.functionality.server.c.b(this.hi, () -> {
            var3.kickPlayer(var5);
         });
         return true;
      } else {
         return false;
      }
   }

   public boolean b(CommandSender var1, String var2) {
      if (this.hk < System.currentTimeMillis()) {
         this.hk = System.currentTimeMillis() + 1000L;
         Player var3 = this.hi.bC();
         String var4 = var1 instanceof ConsoleCommandSender ? ai.idealistic.vacan.functionality.server.a.jb.m("console_name") : var1.getName();
         String var5 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var3, ai.idealistic.vacan.functionality.server.a.jb.m("warning_message").replace("{reason}", var2).replace("{punisher}", var4), (CheckEnums.HackType)null);
         String var6 = ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)var3, ai.idealistic.vacan.functionality.server.a.jb.m("warning_feedback_message").replace("{reason}", var2).replace("{punisher}", var4), (CheckEnums.HackType)null);
         var3.sendMessage(var5);
         var1.sendMessage(var6);
         return true;
      } else {
         return false;
      }
   }
}
