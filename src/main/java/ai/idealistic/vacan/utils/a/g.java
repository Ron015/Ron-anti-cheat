package ai.idealistic.vacan.utils.a;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import org.bukkit.ChatColor;

public final class g {
   private static final Charset kf;
   private static final int kg = 40;

   public static String a(byte[] var0) {
      return new String(var0, kf);
   }

   public static String ac(String var0) {
      try {
         return a(Base64.getDecoder().decode(var0));
      } catch (IllegalArgumentException var2) {
         return var0;
      }
   }

   public static String ad(String var0) {
      return Base64.getEncoder().encodeToString(var0.getBytes());
   }

   public static String d(String var0, String var1) {
      return (var1 == null ? "" : "§" + var1) + var0.replace("_", " ");
   }

   public static String e(String var0, String var1) {
      return (var1 == null ? "" : "§" + var1) + var0.replace("_", "-");
   }

   public static String ae(String var0) {
      return ag(var0.replace(" ", "_"));
   }

   public static String af(String var0) {
      return ag(var0.replace("-", "_"));
   }

   public static String ag(String var0) {
      return ChatColor.stripColor(var0);
   }

   public static String ah(String var0) {
      return var0.replaceAll("&[a-z,0-9]", "");
   }

   public static String b(String[] var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = var1; var3 < var0.length; ++var3) {
         var2.append(var0[var3]).append(" ");
      }

      return var2.substring(0, var2.length() - 1);
   }

   public static List<String> a(String var0, List<String> var1, boolean var2) {
      if (var1 == null) {
         var1 = new ArrayList(40);
      }

      if (!var0.isEmpty()) {
         String var3 = var0.startsWith("§") ? var0.substring(0, 2) : "";
         boolean var4 = !var3.isEmpty();
         if (var4) {
            var0 = var0.substring(2);
         }

         if (!var0.isEmpty()) {
            if (var2) {
               ((List)var1).add("");
            }

            int var5 = 0;

            for(int var6 = 40 + (var4 ? 2 : 0); var5 <= var0.length(); var5 += var6) {
               ((List)var1).add(var3 + b(var0, var5, var5 + var6));
            }
         }
      }

      return (List)var1;
   }

   public static String a(Object[] var0, String var1) {
      int var2 = var0.length - 1;
      if (var2 == -1) {
         return "";
      } else {
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var0.length; ++var4) {
            if (var0[var4] != null) {
               var3.append(var0[var4]);
               if (var4 == var2) {
                  return var3.toString();
               }

               var3.append(var1);
            }
         }

         return var3.toString();
      }
   }

   public static <E> String a(Collection<E> var0, String var1) {
      int var2 = var0.size() - 1;
      if (var2 == -1) {
         return "";
      } else {
         StringBuilder var3 = new StringBuilder();
         int var4 = 0;
         Iterator var5 = var0.iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            if (var6 != null) {
               var3.append(var6);
               if (var4 == var2) {
                  break;
               }

               var3.append(var1);
               ++var4;
            }
         }

         return var3.toString();
      }
   }

   public static String ai(String var0) {
      char[] var1 = var0.toCharArray();
      Arrays.sort(var1);
      return new String(var1);
   }

   public static String b(String var0, int var1, int var2) {
      int var3 = var0.length();
      return var1 <= var3 && var1 <= var2 && var1 != var2 ? (var2 > var3 ? var0.substring(var1, var3) : var0.substring(var1, var2)) : var0;
   }

   public static String aj(String var0) {
      String[] var1 = new String[]{"\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<", ">", "-", "&", "%"};
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (var0.contains(var5)) {
            var0 = var0.replace(var5, "\\" + var5);
         }
      }

      return var0;
   }

   public static boolean a(String[] var0, String var1) {
      String[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (var1.contains(var5)) {
            return true;
         }
      }

      return false;
   }

   public static int f(String var0, String var1) {
      int var2 = 0;

      for(int var3 = 0; (var3 = var0.indexOf(var1, var3)) != -1; var3 += var1.length()) {
         ++var2;
      }

      return var2;
   }

   public static boolean a(char var0) {
      return var0 == '0' || var0 == '1' || var0 == '2' || var0 == '3' || var0 == '4' || var0 == '5' || var0 == '6' || var0 == '7' || var0 == '8' || var0 == '9';
   }

   @Generated
   private g() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   static {
      kf = StandardCharsets.UTF_8;
   }
}
