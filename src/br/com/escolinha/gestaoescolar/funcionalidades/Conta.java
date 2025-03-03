package br.com.escolinha.gestaoescolar.funcionalidades;

public class Conta {

 private  String agencia;
 private int numero;
 private double saldo;

boolean Sacar(double valorSaque){

  var taxaSaque = 0.02;
  if(valorSaque > (saldo + taxaSaque))
    return false;

   saldo-= valorSaque;

   return true;
 }


 double ImprimirSaldo()
 {
  return  saldo;
 }

}
