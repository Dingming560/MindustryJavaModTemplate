package example;

import mindustry.mod.Mod;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.meta.BuildVisibility;

public class ExampleJavaMod extends Mod {
    public static BeamDrill myDrill;

    @Override
    public void loadContent() {
        // 中文内部 ID（既然你想用，咱们就保留）
        myDrill = new BeamDrill("高能等离子钻机");
        
        myDrill.size = 2;
        myDrill.health = 320;
        myDrill.tier = 3;
        myDrill.range = 5;
        myDrill.drillTime = 96f;
        myDrill.itemCapacity = 10;
        myDrill.liquidCapacity = 10;
        myDrill.category = Category.production;
        
        myDrill.buildVisibility = BuildVisibility.shown;
        
        myDrill.requirements(Category.production, ItemStack.with(Items.silicon, 20, Items.beryllium, 30));
        myDrill.consumePower(1.5f);
        
        // 🌟 注意：这里删掉了所有的 drawer 和 DrawGlowRegion 代码！
        // 因为原版 BeamDrill 底层会自动去找 "高能等离子钻机-glow.png" 并让它发光。
    }
}
