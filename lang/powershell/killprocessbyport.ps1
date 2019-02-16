$ports = @(9333,9334)
foreach($port in $ports){
    $text = NETSTAT -nao | findstr $port | Where-Object { $_ -like '*LISTENING*' } 
    $row = $text.Split()
    kill $row[$row.Length - 1]
}