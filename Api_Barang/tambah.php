<?php
  $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_barang";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $kd_barang=$_POST['kd_barang'];
   $nm_barang=$_POST['nm_barang'];
   $keterangan=$_POST['keterangan'];

   $query="INSERT INTO tb_barang(kd_barang,nm_barang,keterangan) VALUES('$kd_barang','$nm_barang','$keterangan')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Susccess'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal ditambahkan'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>