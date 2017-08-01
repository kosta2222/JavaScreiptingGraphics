function say(){
return "Say helo!";

}
var a=Java.type("testsapr.TestSapr");
var t=Java.type("int[]");
var x=new t(5);
var y=new t(5);
x[0]=-100;
y[0]=100;
x[1]=200;
y[1]=150;
//x[2]=-100;
//y[2]=700;
var obj=new a();
obj.doDrawPolyLine(x,y);
