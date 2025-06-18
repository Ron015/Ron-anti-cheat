package me.vagdedes.spartan.api;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;
import me.vagdedes.spartan.api.system.Enums;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CheckPunishmentToggleEvent extends Event implements Cancellable {
   private final CheckEnums.HackType ht;
   private final Enums.ToggleAction ta;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public CheckPunishmentToggleEvent(CheckEnums.HackType var1, Enums.ToggleAction var2) {
      this.ht = var1;
      this.ta = var2;
      this.cancelled = false;
   }

   public CheckEnums.HackType getHackType() {
      return this.ht;
   }

   public Enums.ToggleAction getToggleAction() {
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
