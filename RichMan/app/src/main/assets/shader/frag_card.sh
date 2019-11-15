#version 300 es
precision mediump float;
in vec2 vTextureCoord; //���մӶ�����ɫ�������Ĳ���
uniform sampler2D sTexture;//������������
uniform int cardCount;//��Ƭ��������
out vec4 fragColor;
void main()                         
{
   vec4 Color;
   //����ƬԪ�������в�������ɫֵ  
   Color = texture(sTexture, vTextureCoord);
   //��Ƭ����Ϊ0 ��ʾ��ɫ
   if(cardCount==0&&Color.a!=0.0)
   {
       float  finalColor = (Color.r+Color.g+Color.b)/3.0;
        Color= vec4(finalColor,finalColor,finalColor,1.0);
   }
   fragColor = Color;
}              