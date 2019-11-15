#version 300 es
precision mediump float;
in vec2 vTextureCoord; //接收从顶点着色器过来的参数
uniform sampler2D sTexture;//纹理内容数据
uniform int cardCount;//卡片数量属性
out vec4 fragColor;
void main()                         
{
   vec4 Color;
   //给此片元从纹理中采样出颜色值  
   Color = texture(sTexture, vTextureCoord);
   //卡片数量为0 显示灰色
   if(cardCount==0&&Color.a!=0.0)
   {
       float  finalColor = (Color.r+Color.g+Color.b)/3.0;
        Color= vec4(finalColor,finalColor,finalColor,1.0);
   }
   fragColor = Color;
}              