package me.vagdedes.spartan.api.system;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;

public class Enums {
   public static enum ToggleAction {
      ENABLE(ai.idealistic.vacan.api.ToggleAction.ENABLE),
      DISABLE(ai.idealistic.vacan.api.ToggleAction.DISABLE);

      private final ai.idealistic.vacan.api.ToggleAction toggleAction;

      private ToggleAction(ai.idealistic.vacan.api.ToggleAction var3) {
         this.toggleAction = var3;
      }

      @Generated
      public ai.idealistic.vacan.api.ToggleAction getToggleAction() {
         return this.toggleAction;
      }

      // $FF: synthetic method
      private static Enums.ToggleAction[] $values() {
         return new Enums.ToggleAction[]{ENABLE, DISABLE};
      }
   }

   public static enum Permission {
      CONDITION(ai.idealistic.vacan.api.Permission.CONDITION),
      WAVE(ai.idealistic.vacan.api.Permission.WAVE),
      ADMIN(ai.idealistic.vacan.api.Permission.ADMIN),
      RELOAD(ai.idealistic.vacan.api.Permission.RELOAD),
      KICK(ai.idealistic.vacan.api.Permission.KICK),
      BYPASS(ai.idealistic.vacan.api.Permission.BYPASS),
      MANAGE(ai.idealistic.vacan.api.Permission.MANAGE),
      INFO(ai.idealistic.vacan.api.Permission.INFO),
      WARN(ai.idealistic.vacan.api.Permission.WARN),
      USE_BYPASS(ai.idealistic.vacan.api.Permission.USE_BYPASS),
      NOTIFICATIONS(ai.idealistic.vacan.api.Permission.NOTIFICATIONS),
      BEDROCK(ai.idealistic.vacan.api.Permission.BEDROCK);

      private final ai.idealistic.vacan.api.Permission permission;

      private Permission(ai.idealistic.vacan.api.Permission var3) {
         this.permission = var3;
      }

      @Generated
      public ai.idealistic.vacan.api.Permission getPermission() {
         return this.permission;
      }

      // $FF: synthetic method
      private static Enums.Permission[] $values() {
         return new Enums.Permission[]{CONDITION, WAVE, ADMIN, RELOAD, KICK, BYPASS, MANAGE, INFO, WARN, USE_BYPASS, NOTIFICATIONS, BEDROCK};
      }
   }

   public static enum HackType {
      XRay(CheckEnums.HackType.X_RAY),
      NoSwing(CheckEnums.HackType.NO_SWING),
      IrregularMovements(CheckEnums.HackType.IRREGULAR_MOVEMENTS),
      ImpossibleActions(CheckEnums.HackType.IMPOSSIBLE_ACTIONS),
      AutoRespawn(CheckEnums.HackType.AUTO_RESPAWN),
      InventoryClicks(CheckEnums.HackType.INVENTORY_CLICKS),
      Criticals(CheckEnums.HackType.CRITICALS),
      GhostHand(CheckEnums.HackType.GHOST_HAND),
      BlockReach(CheckEnums.HackType.BLOCK_REACH),
      FastBow(CheckEnums.HackType.FAST_BOW),
      FastClicks(CheckEnums.HackType.FAST_CLICKS),
      FastHeal(CheckEnums.HackType.FAST_HEAL),
      ImpossibleInventory(CheckEnums.HackType.IMPOSSIBLE_INVENTORY),
      HitReach(CheckEnums.HackType.HIT_REACH),
      FastBreak(CheckEnums.HackType.FAST_BREAK),
      FastPlace(CheckEnums.HackType.FAST_PLACE),
      MorePackets(CheckEnums.HackType.MORE_PACKETS),
      FastEat(CheckEnums.HackType.FAST_EAT),
      Velocity(CheckEnums.HackType.VELOCITY),
      KillAura(CheckEnums.HackType.KILL_AURA);

      private final CheckEnums.HackType hackType;

      private HackType(CheckEnums.HackType var3) {
         this.hackType = var3;
      }

      @Generated
      public CheckEnums.HackType getHackType() {
         return this.hackType;
      }

      // $FF: synthetic method
      private static Enums.HackType[] $values() {
         return new Enums.HackType[]{XRay, NoSwing, IrregularMovements, ImpossibleActions, AutoRespawn, InventoryClicks, Criticals, GhostHand, BlockReach, FastBow, FastClicks, FastHeal, ImpossibleInventory, HitReach, FastBreak, FastPlace, MorePackets, FastEat, Velocity, KillAura};
      }
   }
}
