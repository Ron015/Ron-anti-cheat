package ai.idealistic.vacan.functionality.c.a;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class a {
   static boolean a(CommandSender var0, String var1, String var2, String var3, boolean var4) {
      try {
         if (var0 instanceof Player) {
            TextComponent var5 = new TextComponent();
            var5.setText(var1);
            var5.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, (new ComponentBuilder(var2)).create()));
            if (var3 != null) {
               var5.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, var3));
            }

            ((Player)var0).spigot().sendMessage(var5);
         } else {
            var0.sendMessage(var1);
         }

         return true;
      } catch (Exception var6) {
         if (var4) {
            var0.sendMessage(var1);
         }

         return false;
      }
   }

   static boolean b(CommandSender var0, String var1, String var2, String var3, boolean var4) {
      try {
         if (var0 instanceof Player) {
            TextComponent var5 = new TextComponent();
            var5.setText(var1);
            var5.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, var3));
            var5.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, (new ComponentBuilder(var2)).create()));
            ((Player)var0).spigot().sendMessage(var5);
         } else {
            var0.sendMessage(var1);
         }

         return true;
      } catch (Exception var6) {
         if (var4) {
            var0.sendMessage(var1);
         }

         return false;
      }
   }
}
