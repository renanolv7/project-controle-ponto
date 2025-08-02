import 'dart:async';

import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class HoraState extends StatefulWidget {
  const HoraState({super.key});

  @override
  State<HoraState> createState() => _HoraState();
}

class _HoraState extends State<HoraState> {
  late String tempoString;
  late String dataString;
  
  void getTime() {
    final infoAtual = DateTime.now();

    final tempoAjustado = infoAtual;
    final tempoFormatado = DateFormat('HH:mm:ss');
    final dataFormatada = DateFormat('EEEE \'| \' d \'de\' MMMM \' | \' yyyy', 'pt_BR');

    setState(() {
      tempoString = tempoFormatado.format(tempoAjustado);
      dataString = dataFormatada.format(tempoAjustado);
    });

  }

  @override
  void initState() {
    getTime();
    super.initState();
    Timer.periodic(Duration(seconds: 1), 
                  (Timer t) => getTime());
  }
  

  @override
  Widget build(BuildContext context) {
    return Container(
      
      decoration: BoxDecoration(
        color: Colors.white, 
        borderRadius: BorderRadius.circular(15.0)
      ),

      padding: EdgeInsets.symmetric(horizontal: 36, vertical: 18),
  
      child: Column(
        mainAxisSize: MainAxisSize.min,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Text(
            tempoString,
            style: TextStyle(
              fontSize: 70,
              fontWeight: FontWeight.bold,
              color: Colors.grey[800],
            ),
          ),
          const SizedBox(height: 8),
          Text(
            dataString,
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.w500,
              color: Colors.grey[500],
            ),
          ),
        ],
      ),
    );

  }

  void postInfosHora(){

  }
}


