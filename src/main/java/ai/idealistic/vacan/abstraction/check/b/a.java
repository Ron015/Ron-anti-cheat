package ai.idealistic.vacan.abstraction.check.b;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.abstraction.f.c;

public class a extends e {
   private final b ah = new b(this);
   private final ai.idealistic.vacan.abstraction.check.b ai;

   public a(CheckEnums.HackType var1, c var2, String var3) {
      super(var1, var2);
      this.ai = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, Check.DetectionType.PACKETS, "detection_option_name_in_checks_yml", true);
   }

   protected void a(boolean var1, Object var2) {
   }

   protected boolean m() {
      this.ah.u();
      return true;
   }
}
