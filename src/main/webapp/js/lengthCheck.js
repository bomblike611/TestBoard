/**
 * 
 */
function lengthCheck(content,max_length)
{
    var i;
    var string = content.value;
    var one_char;
    var str_byte = 0;
    var str_length = 0;
  for(i = 0 ; i < string.length ; i++)
{
  // 한글자추출
  one_char = string.charAt(i);

  // 한글이면 2를 더한다.
  if (escape(one_char).length > 4)
  {
     str_byte = str_byte+2;
  }
  // 그외의 경우는 1을 더한다.
  else
  {
     str_byte++;
  }

  // 전체 크기가 li_max를 넘지않으면
  if(str_byte <= max_length)
  {
     str_length = i + 1;
  }
}
// 전체길이를 초과하면
  if(str_byte > max_length)
  {
    alert(" 글자를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. ");
    content.value = string.substr(0, str_length);
  }

}  

