package example;

import mindustry.world.blocks.distribution.ItemBridge;
import arc.struct.Seq;
import arc.math.geom.Point2;

public class OmniBridge extends ItemBridge {
    public OmniBridge(String name) {
        super(name);
    }

    // 用纯 Java 重写拖拽路径生成，实现斜线拖拽
    @Override
    public void changePlacementPath(Seq<Point2> points, int rotation) {
        if (points.size < 2) return;
        Point2 start = points.first();
        Point2 end = points.peek();
        
        if (start.x == end.x && start.y == end.y) return;
        
        points.clear();
        
        int x0 = start.x, y0 = start.y;
        int x1 = end.x, y1 = end.y;
        int dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
        int dy = -Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1; 
        int err = dx + dy, e2; 
        
        while (true) {
            points.add(new Point2(x0, y0));
            if (x0 == x1 && y0 == y1) break;
            e2 = 2 * err;
            if (e2 >= dy) { err += dy; x0 += sx; } 
            if (e2 <= dx) { err += dx; y0 += sy; } 
        }
    }
}
