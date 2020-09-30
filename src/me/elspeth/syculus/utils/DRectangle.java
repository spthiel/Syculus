package me.elspeth.syculus.utils;

public class DRectangle {

    public double x, y, width, height;

    public DRectangle() {
        this(0,0,1,1);
    }

    public DRectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(DRectangle other) {

        double tw = this.width;
        double th = this.height;
        double rw = other.width;
        double rh = other.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        double tx = this.x;
        double ty = this.y;
        double rx = other.x;
        double ry = other.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));

    }
}
