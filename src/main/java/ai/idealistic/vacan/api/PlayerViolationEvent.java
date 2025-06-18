package ai.idealistic.vacan.api;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerViolationEvent extends Event implements Cancellable {
   private final Player p;
   private final CheckEnums.HackType h;
   private final String m;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public PlayerViolationEvent(Player var1, CheckEnums.HackType var2, String var3) {
      this.p = var1;
      this.h = var2;
      this.m = var3;
      this.cancelled = false;
      me.vagdedes.spartan.api.PlayerViolationEvent var4 = new me.vagdedes.spartan.api.PlayerViolationEvent(var1, var2, var3);
      var4.setCancelled(this.isCancelled());
      Bukkit.getPluginManager().callEvent(var4);
   }

   public Player getPlayer() {
      return this.p;
   }

   public CheckEnums.HackType getHackType() {
      return this.h;
   }

   public String getMessage() {
      return this.m;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }

   @Generated
   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   @Generated
   public boolean isCancelled() {
      return this.cancelled;
   }
}
