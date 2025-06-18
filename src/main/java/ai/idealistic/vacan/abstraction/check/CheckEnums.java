package ai.idealistic.vacan.abstraction.check;

import ai.idealistic.vacan.abstraction.check.implementation.a.f;
import ai.idealistic.vacan.abstraction.check.implementation.b.a.j;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import org.bukkit.Material;

public class CheckEnums {
   public static enum HackCategoryType {
      COMBAT(Material.IRON_SWORD),
      MOVEMENT(Material.FEATHER),
      WORLD(Material.DIAMOND_PICKAXE),
      MISCELLANEOUS(ai.idealistic.vacan.utils.minecraft.a.d.au("crafting_table"));

      public final Material material;

      private HackCategoryType(Material var3) {
         this.material = var3;
      }

      public String toString() {
         return super.toString().toLowerCase().replace("_", "-");
      }

      // $FF: synthetic method
      private static CheckEnums.HackCategoryType[] $values() {
         return new CheckEnums.HackCategoryType[]{COMBAT, MOVEMENT, WORLD, MISCELLANEOUS};
      }
   }

   public static enum HackType {
      HIT_REACH(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.d.class, new String[]{"This check will prevent client modules", "that allow a player to hit entities", "from an abnormally long distance"}),
      CRITICALS(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.a.class, new String[]{"This check will prevent client modules", "that allow a player to critical damage", "an entity without properly moving."}),
      FAST_BOW(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.b.class, new String[]{"This check will prevent client modules", "that allow a player to shoot arrows", "in abnormally fast rates."}),
      FAST_CLICKS(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.c.class, new String[]{"This check will prevent client modules", "that allow a player to click abnormally fast", "or have an irregular clicking consistency."}),
      VELOCITY(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.e.class, new String[]{"This check will prevent client modules", "that allow a player to receive abnormal", "amounts of knockback, or none at all."}),
      KILL_AURA(CheckEnums.HackCategoryType.COMBAT, ai.idealistic.vacan.abstraction.check.implementation.combat.killaura.e.class, new String[]{"This check will prevent client modules", "that allow a player to have an 'apparent'", "combat advantage against any entity."}),
      IRREGULAR_MOVEMENTS(CheckEnums.HackCategoryType.MOVEMENT, j.class, new String[]{"This check will prevent client modules", "that allow a player to move abnormally,", "such as stepping blocks or climbing walls."}),
      MORE_PACKETS(CheckEnums.HackCategoryType.MOVEMENT, ai.idealistic.vacan.abstraction.check.implementation.b.a.class, new String[]{"This check will prevent client modules", "that allow a player to send abnormally", "high amounts of movement packets."}),
      X_RAY(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.e.class, new String[]{"This check will prevent client modules", "that allow a player to see through blocks", "in order to find rare ores, such as diamonds,", "gold, and even emerald. (Logs must be enabled)"}),
      IMPOSSIBLE_ACTIONS(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.a.a.class, new String[]{"This check will prevent client modules", "that allow a player to execute actions", "in abnormal cases, such as when sleeping."}),
      FAST_BREAK(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.b.class, new String[]{"This check will prevent client modules", "that allow a player to break one or multiple", "blocks irregularly fast."}),
      FAST_PLACE(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.c.class, new String[]{"This check will prevent client modules", "that allow a player to place blocks", "in abnormally fast rates."}),
      GHOST_HAND(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.d.class, new String[]{"This check will prevent client modules", "that allow a player to interact or break", "blocks through walls of blocks."}),
      BLOCK_REACH(CheckEnums.HackCategoryType.WORLD, ai.idealistic.vacan.abstraction.check.implementation.c.a.class, new String[]{"This check will prevent client modules", "that allow a player to build or break", "blocks within an abnormally long distance."}),
      NO_SWING(CheckEnums.HackCategoryType.MISCELLANEOUS, f.class, new String[]{"This check will prevent client modules", "that manipulate packets and prevent", "interaction animations from being shown."}),
      AUTO_RESPAWN(CheckEnums.HackCategoryType.MISCELLANEOUS, ai.idealistic.vacan.abstraction.check.implementation.a.a.class, new String[]{"This check will prevent client modules", "that allow a player to respawn faster", "than what is physically expected."}),
      INVENTORY_CLICKS(CheckEnums.HackCategoryType.MISCELLANEOUS, ai.idealistic.vacan.abstraction.check.implementation.a.e.class, new String[]{"This check will prevent client modules", "that allow a player to interact with an", "amount of items, in abnormally fast rates."}),
      FAST_HEAL(CheckEnums.HackCategoryType.MISCELLANEOUS, ai.idealistic.vacan.abstraction.check.implementation.a.c.class, new String[]{"This check will prevent client modules", "that allow a player to heal faster", "than what is physically allowed."}),
      IMPOSSIBLE_INVENTORY(CheckEnums.HackCategoryType.MISCELLANEOUS, ai.idealistic.vacan.abstraction.check.implementation.a.d.class, new String[]{"This check will prevent client modules", "that allow a player to interact with", "an inventory in abnormal cases, such", "as when sprinting or walking."}),
      FAST_EAT(CheckEnums.HackCategoryType.MISCELLANEOUS, ai.idealistic.vacan.abstraction.check.implementation.a.b.class, new String[]{"This check will prevent client modules", "that allow a player to consume an amount", "of food in an abnormal amount of time."});

      private Check check;
      public final CheckEnums.HackCategoryType category;
      public final Class<?> executor;
      public final String[] description;
      private final Map<String, Long> detections;

      private HackType(CheckEnums.HackCategoryType var3, Class<?> var4, String[] var5) {
         this.category = var3;
         this.executor = var4;
         this.description = var5;
         this.detections = new ConcurrentHashMap();
         this.check = new Check(this);
      }

      public void resetCheck() {
         if (this.check != null) {
            this.check = new Check(this);
         }

      }

      public void addDetection(String var1, long var2) {
         this.detections.put(var1, var2);
      }

      public void removeDetection(String var1) {
         this.detections.remove(var1);
      }

      public long getDefaultAverageTime(String var1) {
         return (Long)this.detections.get(var1);
      }

      public Collection<String> getDetections() {
         return this.detections.keySet();
      }

      public String toString() {
         return super.toString().toLowerCase().replace("_", "-");
      }

      @Generated
      public Check getCheck() {
         return this.check;
      }

      // $FF: synthetic method
      private static CheckEnums.HackType[] $values() {
         return new CheckEnums.HackType[]{HIT_REACH, CRITICALS, FAST_BOW, FAST_CLICKS, VELOCITY, KILL_AURA, IRREGULAR_MOVEMENTS, MORE_PACKETS, X_RAY, IMPOSSIBLE_ACTIONS, FAST_BREAK, FAST_PLACE, GHOST_HAND, BLOCK_REACH, NO_SWING, AUTO_RESPAWN, INVENTORY_CLICKS, FAST_HEAL, IMPOSSIBLE_INVENTORY, FAST_EAT};
      }
   }
}
