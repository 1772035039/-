package 四则;

public class Fraction { private int a;
//分母
private int b;
 
 //分数
 public Fraction(int a, int b) {
     this.a = a;
        if (b == 0) {
            throw new ArithmeticException("分母不能为零");
        } else {
            this.b = b;
        }
        simple();
 }
 

//化简
 private Fraction simple() {
        int gcd = this.gcd(this.a, this.b);
        this.a /= gcd;
        this.b /= gcd;
        return this;
 }
 
 //最大公约数
 private int gcd(int a, int b) {
        int mod = a % b;
        if (mod == 0) {
            return b;
        } else {
            return gcd(b, mod);
        }
    }

 //四则运算
    public Fraction add(Fraction second) {//加法
        return new Fraction(this.a * second.b + second.a * this.b,
                this.b * second.b);
    }

    public Fraction sub(Fraction second) {//减法
        return new Fraction(this.a * second.b - second.a * this.b,
                this.b * second.b);
    }

    public Fraction mult(Fraction second) {//乘法
        return new Fraction(this.a*second.a,
                this.b * second.b);
    }

    public Fraction div(Fraction second) {//除法
        return new Fraction(this.a*second.b,
                this.b * second.a);
    }
    
    
    //分数类转字符串类型
    public String toString() {
        if (this.b==1) {
            return String.valueOf(a);
        }
        else if(this.a>this.b) {
            int c=0;
            c=this.a/this.b;
            this.a=this.a%this.b;
            return String.valueOf(c)+"'"+String.valueOf(a)+"/"+String.valueOf(b);
        } 
        else{
        return String.valueOf(a)+"/"+String.valueOf(b);}
    }
    
    public static Fraction tofraction(String str) {
        str=str.replaceAll(" ", "");
        int a=1;
        int b=1;
        int s1=str.indexOf("'");
        int s2=str.indexOf("/");
        if(s1!=-1) {
            int c=Integer.valueOf(str.substring(0,s1));
            b=Integer.valueOf(str.substring(s2+1));
            a=c*b+Integer.valueOf(str.substring(s1+1,s2));
        } else if(s2!=-1) {
            b=Integer.valueOf(str.substring(s2+1));
            a=Integer.valueOf(str.substring(0,s2));
        } else {
            a=Integer.valueOf(str);
            b=1;
        }
        return new Fraction(a,b);
    }

    //比较大小,比较此分数是否大于输入分数
    public boolean isgreaterthan2(Fraction f) {
        int z=this.a * f.b - f.a * this.b;
        if(z>0) {return true;}
        else return false;
    }
    public boolean isZero() {
        return a == 0;
    }

}
