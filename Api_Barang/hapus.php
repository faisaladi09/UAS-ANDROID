<?php
   
   $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_barang";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }
 
 if($_SERVER['REQUEST_METHOD'])
{
   $id=$_POST['id'];
   $query="DELETE FROM tb_barang WHERE id=$id";
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Success Delete'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal dihapu'));

}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>