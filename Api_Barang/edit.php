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
   $kd_barang=$_POST['kd_barang'];
   $nm_barang=$_POST['nm_barang'];
   $keterangan=$_POST['keterangan'];

   $query="UPDATE tb_barang SET kd_barang='$kd_barang',nm_barang='$nm_barang',keterangan='$keterangan' WHERE id='$id'";
   
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Success Update'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'Not Success'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak nya gk valid'));
}

header('Content-Type: application/json');
?>
                     