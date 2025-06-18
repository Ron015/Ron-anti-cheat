package ai.idealistic.vacan.abstraction.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class a implements PlayerInventory {
   private final PlayerInventory ge;

   public a(PlayerInventory var1) {
      this.ge = var1;
   }

   @Nullable
   @NotNull
   public ItemStack[] getArmorContents() {
      ItemStack[] var10000 = this.ge == null ? new ItemStack[0] : this.ge.getArmorContents();
      if (var10000 == null) {
         d(0);
      }

      return var10000;
   }

   @Nullable
   @NotNull
   public ItemStack[] getExtraContents() {
      ItemStack[] var10000 = this.ge == null ? new ItemStack[0] : this.ge.getExtraContents();
      if (var10000 == null) {
         d(1);
      }

      return var10000;
   }

   @Nullable
   public ItemStack getHelmet() {
      return this.ge == null ? null : this.ge.getHelmet();
   }

   @Nullable
   public ItemStack getChestplate() {
      return this.ge == null ? null : this.ge.getChestplate();
   }

   @Nullable
   public ItemStack getLeggings() {
      return this.ge == null ? null : this.ge.getLeggings();
   }

   @Nullable
   public ItemStack getBoots() {
      return this.ge == null ? null : this.ge.getBoots();
   }

   public int getSize() {
      return this.ge == null ? 0 : this.ge.getSize();
   }

   public int getMaxStackSize() {
      return this.ge == null ? 0 : this.ge.getMaxStackSize();
   }

   public void setMaxStackSize(int var1) {
      if (this.ge != null) {
         this.ge.setMaxStackSize(var1);
      }

   }

   @Nullable
   public ItemStack getItem(int var1) {
      return this.ge == null ? null : this.ge.getItem(var1);
   }

   public void setItem(int var1, @Nullable ItemStack var2) {
      if (this.ge != null) {
         this.ge.setItem(var1, var2);
      }

   }

   @NotNull
   public HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... var1) {
      if (var1 == null) {
         d(2);
      }

      if (this.ge != null) {
         HashMap var10000 = this.ge.addItem(var1);
         if (var10000 == null) {
            d(3);
         }

         return var10000;
      } else {
         return new HashMap(0);
      }
   }

   @NotNull
   public HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... var1) {
      if (var1 == null) {
         d(4);
      }

      if (this.ge != null) {
         HashMap var10000 = this.ge.removeItem(var1);
         if (var10000 == null) {
            d(5);
         }

         return var10000;
      } else {
         return new HashMap(0);
      }
   }

   @NotNull
   public HashMap<Integer, ItemStack> a(@NotNull ItemStack... var1) {
      if (var1 == null) {
         d(6);
      }

      if (this.ge != null) {
         HashMap var10000 = this.ge.removeItemAnySlot(var1);
         if (var10000 == null) {
            d(7);
         }

         return var10000;
      } else {
         return new HashMap(0);
      }
   }

   @Nullable
   @NotNull
   public ItemStack[] getContents() {
      ItemStack[] var10000 = this.ge == null ? new ItemStack[0] : this.ge.getContents();
      if (var10000 == null) {
         d(8);
      }

      return var10000;
   }

   public void setContents(@Nullable @NotNull ItemStack[] var1) {
      if (var1 == null) {
         d(9);
      }

      if (this.ge != null) {
         this.ge.setContents(var1);
      }

   }

   @Nullable
   @NotNull
   public ItemStack[] getStorageContents() {
      ItemStack[] var10000 = this.ge == null ? new ItemStack[0] : this.ge.getStorageContents();
      if (var10000 == null) {
         d(10);
      }

      return var10000;
   }

   public void setStorageContents(@Nullable @NotNull ItemStack[] var1) {
      if (var1 == null) {
         d(11);
      }

      if (this.ge != null) {
         this.ge.setStorageContents(var1);
      }

   }

   public boolean contains(@NotNull Material var1) {
      if (var1 == null) {
         d(12);
      }

      return this.ge != null && this.ge.contains(var1);
   }

   public boolean contains(@Nullable ItemStack var1) {
      return this.ge != null && this.ge.contains(var1);
   }

   public boolean contains(@NotNull Material var1, int var2) {
      if (var1 == null) {
         d(13);
      }

      return this.ge != null && this.ge.contains(var1, var2);
   }

   public boolean contains(@Nullable ItemStack var1, int var2) {
      return this.ge != null && this.ge.contains(var1, var2);
   }

   public boolean containsAtLeast(@Nullable ItemStack var1, int var2) {
      return this.ge != null && this.ge.containsAtLeast(var1, var2);
   }

   @NotNull
   public HashMap<Integer, ? extends ItemStack> all(@NotNull Material var1) {
      if (var1 == null) {
         d(14);
      }

      HashMap var10000 = this.ge == null ? new HashMap(0) : this.ge.all(var1);
      if (var10000 == null) {
         d(15);
      }

      return var10000;
   }

   @NotNull
   public HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack var1) {
      HashMap var10000 = this.ge == null ? new HashMap(0) : this.ge.all(var1);
      if (var10000 == null) {
         d(16);
      }

      return var10000;
   }

   public int first(@NotNull Material var1) {
      if (var1 == null) {
         d(17);
      }

      return this.ge == null ? 0 : this.ge.first(var1);
   }

   public int first(@NotNull ItemStack var1) {
      if (var1 == null) {
         d(18);
      }

      return this.ge == null ? 0 : this.ge.first(var1);
   }

   public int firstEmpty() {
      return this.ge == null ? 0 : this.ge.firstEmpty();
   }

   public boolean isEmpty() {
      return this.ge != null && this.ge.isEmpty();
   }

   public void remove(@NotNull Material var1) {
      if (var1 == null) {
         d(19);
      }

      if (this.ge != null) {
         this.ge.remove(var1);
      }

   }

   public void remove(@NotNull ItemStack var1) {
      if (var1 == null) {
         d(20);
      }

      if (this.ge != null) {
         this.ge.remove(var1);
      }

   }

   public void clear(int var1) {
      if (this.ge != null) {
         this.ge.clear(var1);
      }

   }

   public void clear() {
      if (this.ge != null) {
         this.ge.clear();
      }

   }

   public int bz() {
      return this.ge == null ? 0 : this.ge.close();
   }

   @NotNull
   public List<HumanEntity> getViewers() {
      Object var10000 = this.ge == null ? new ArrayList(0) : this.ge.getViewers();
      if (var10000 == null) {
         d(21);
      }

      return (List)var10000;
   }

   @NotNull
   public InventoryType getType() {
      InventoryType var10000 = this.ge == null ? InventoryType.PLAYER : this.ge.getType();
      if (var10000 == null) {
         d(22);
      }

      return var10000;
   }

   public void setItem(@NotNull EquipmentSlot var1, @Nullable ItemStack var2) {
      if (var1 == null) {
         d(23);
      }

      if (this.ge != null) {
         this.ge.setItem(var1, var2);
      }

   }

   @NotNull
   public ItemStack getItem(@NotNull EquipmentSlot var1) {
      if (var1 == null) {
         d(24);
      }

      ItemStack var10000 = this.ge == null ? new ItemStack(Material.AIR) : this.ge.getItem(var1);
      if (var10000 == null) {
         d(25);
      }

      return var10000;
   }

   public void setArmorContents(@Nullable ItemStack[] var1) {
      if (this.ge != null) {
         this.ge.setArmorContents(var1);
      }

   }

   public void setExtraContents(@Nullable ItemStack[] var1) {
      if (this.ge != null) {
         this.ge.setExtraContents(var1);
      }

   }

   public void setHelmet(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setHelmet(var1);
      }

   }

   public void setChestplate(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setChestplate(var1);
      }

   }

   public void setLeggings(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setLeggings(var1);
      }

   }

   public void setBoots(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setBoots(var1);
      }

   }

   @NotNull
   public ItemStack getItemInMainHand() {
      ItemStack var10000 = this.ge == null ? new ItemStack(Material.AIR) : this.ge.getItemInMainHand();
      if (var10000 == null) {
         d(26);
      }

      return var10000;
   }

   public void setItemInMainHand(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setItemInMainHand(var1);
      }

   }

   @NotNull
   public ItemStack getItemInOffHand() {
      ItemStack var10000 = this.ge == null ? new ItemStack(Material.AIR) : this.ge.getItemInOffHand();
      if (var10000 == null) {
         d(27);
      }

      return var10000;
   }

   public void setItemInOffHand(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setItemInOffHand(var1);
      }

   }

   /** @deprecated */
   @Deprecated
   @NotNull
   public ItemStack getItemInHand() {
      ItemStack var10000 = this.ge == null ? new ItemStack(Material.AIR) : this.ge.getItemInHand();
      if (var10000 == null) {
         d(28);
      }

      return var10000;
   }

   /** @deprecated */
   @Deprecated
   public void setItemInHand(@Nullable ItemStack var1) {
      if (this.ge != null) {
         this.ge.setItemInHand(var1);
      }

   }

   public int getHeldItemSlot() {
      return this.ge == null ? 0 : this.ge.getHeldItemSlot();
   }

   public void setHeldItemSlot(int var1) {
      if (this.ge != null) {
         this.ge.setHeldItemSlot(var1);
      }

   }

   @Nullable
   public HumanEntity getHolder() {
      return this.ge == null ? null : this.ge.getHolder();
   }

   @Nullable
   public InventoryHolder t(boolean var1) {
      return this.ge == null ? null : this.ge.getHolder(var1);
   }

   @NotNull
   public ListIterator<ItemStack> iterator() {
      ListIterator var10000;
      if (this.ge == null) {
         ArrayList var1 = new ArrayList(0);
         var10000 = var1.listIterator();
         if (var10000 == null) {
            d(29);
         }

         return var10000;
      } else {
         var10000 = this.ge.iterator();
         if (var10000 == null) {
            d(30);
         }

         return var10000;
      }
   }

   @NotNull
   public ListIterator<ItemStack> iterator(int var1) {
      ListIterator var10000;
      if (this.ge == null) {
         ArrayList var2 = new ArrayList(0);
         var10000 = var2.listIterator(var1);
         if (var10000 == null) {
            d(31);
         }

         return var10000;
      } else {
         var10000 = this.ge.iterator(var1);
         if (var10000 == null) {
            d(32);
         }

         return var10000;
      }
   }

   @Nullable
   public Location getLocation() {
      return this.ge == null ? null : this.ge.getLocation();
   }

   // $FF: synthetic method
   private static void d(int var0) {
      String var10000;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 15:
      case 16:
      case 21:
      case 22:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      default:
         var10000 = "@NotNull method %s.%s must not return null";
         break;
      case 2:
      case 4:
      case 6:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 17:
      case 18:
      case 19:
      case 20:
      case 23:
      case 24:
         var10000 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
      }

      byte var10001;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 15:
      case 16:
      case 21:
      case 22:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      default:
         var10001 = 2;
         break;
      case 2:
      case 4:
      case 6:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 17:
      case 18:
      case 19:
      case 20:
      case 23:
      case 24:
         var10001 = 3;
      }

      Object[] var2 = new Object[var10001];
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 15:
      case 16:
      case 21:
      case 22:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      default:
         var2[0] = "ai/idealistic/vacan/abstraction/protocol/CPlayerInventory";
         break;
      case 2:
      case 4:
      case 6:
      case 9:
      case 11:
         var2[0] = "itemStacks";
         break;
      case 12:
      case 13:
      case 14:
      case 17:
      case 19:
         var2[0] = "material";
         break;
      case 18:
      case 20:
         var2[0] = "itemStack";
         break;
      case 23:
      case 24:
         var2[0] = "equipmentSlot";
      }

      switch(var0) {
      case 0:
      default:
         var2[1] = "getArmorContents";
         break;
      case 1:
         var2[1] = "getExtraContents";
         break;
      case 2:
      case 4:
      case 6:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 17:
      case 18:
      case 19:
      case 20:
      case 23:
      case 24:
         var2[1] = "ai/idealistic/vacan/abstraction/protocol/CPlayerInventory";
         break;
      case 3:
         var2[1] = "addItem";
         break;
      case 5:
         var2[1] = "removeItem";
         break;
      case 7:
         var2[1] = "removeItemAnySlot";
         break;
      case 8:
         var2[1] = "getContents";
         break;
      case 10:
         var2[1] = "getStorageContents";
         break;
      case 15:
      case 16:
         var2[1] = "all";
         break;
      case 21:
         var2[1] = "getViewers";
         break;
      case 22:
         var2[1] = "getType";
         break;
      case 25:
         var2[1] = "getItem";
         break;
      case 26:
         var2[1] = "getItemInMainHand";
         break;
      case 27:
         var2[1] = "getItemInOffHand";
         break;
      case 28:
         var2[1] = "getItemInHand";
         break;
      case 29:
      case 30:
      case 31:
      case 32:
         var2[1] = "iterator";
      }

      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 15:
      case 16:
      case 21:
      case 22:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      default:
         break;
      case 2:
         var2[2] = "addItem";
         break;
      case 4:
         var2[2] = "removeItem";
         break;
      case 6:
         var2[2] = "removeItemAnySlot";
         break;
      case 9:
         var2[2] = "setContents";
         break;
      case 11:
         var2[2] = "setStorageContents";
         break;
      case 12:
      case 13:
         var2[2] = "contains";
         break;
      case 14:
         var2[2] = "all";
         break;
      case 17:
      case 18:
         var2[2] = "first";
         break;
      case 19:
      case 20:
         var2[2] = "remove";
         break;
      case 23:
         var2[2] = "setItem";
         break;
      case 24:
         var2[2] = "getItem";
      }

      var10000 = String.format(var10000, var2);
      Object var1;
      String var4;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 15:
      case 16:
      case 21:
      case 22:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      default:
         IllegalStateException var3 = new IllegalStateException;
         var4 = var10000;
         var1 = var3;
         var3.<init>(var4);
         break;
      case 2:
      case 4:
      case 6:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 17:
      case 18:
      case 19:
      case 20:
      case 23:
      case 24:
         IllegalArgumentException var10002 = new IllegalArgumentException;
         var4 = var10000;
         var1 = var10002;
         var10002.<init>(var4);
      }

      throw var1;
   }
}
