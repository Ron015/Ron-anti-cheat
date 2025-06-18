package ai.idealistic.vacan.api;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;
import me.vagdedes.spartan.api.system.Enums;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CheckSilentToggleEvent extends Event implements Cancellable {
   private final CheckEnums.HackType ht;
   private final ToggleAction ta;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public CheckSilentToggleEvent(CheckEnums.HackType var1, ToggleAction var2) {
      this.ht = var1;
      this.ta = var2;
      this.cancelled = false;
      me.vagdedes.spartan.api.CheckSilentToggleEvent var3 = new me.vagdedes.spartan.api.CheckSilentToggleEvent(var1, Enums.ToggleAction.valueOf(var2.toString()));
      var3.setCancelled(this.isCancelled());
      Bukkit.getPluginManager().callEvent(var3);
   }

   public CheckEnums.HackType getHackType() {
      return this.ht;
   }

   public ToggleAction getToggleAction() {
      return this.ta;
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
