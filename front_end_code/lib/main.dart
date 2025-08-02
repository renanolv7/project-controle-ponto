import 'package:flutter/material.dart';
import 'package:intl/date_symbol_data_local.dart';
import 'package:states_flutter/widgets/hora_state.dart';

main() async {
  await initializeDateFormatting('pt_BR', null);
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Controle de Ponto",
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color.fromARGB(255, 247, 245, 245),
      
      appBar: AppBar(
        title: const Text("Controle AI"),
        centerTitle: true,
        backgroundColor: const Color.fromARGB(255, 27, 0, 73),
        titleTextStyle: const TextStyle(
          color: Colors.white,
          fontSize: 24,
          fontWeight: FontWeight.bold
        ),
      ),
      body: SizedBox(
        
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            const SizedBox(height: 40),
            HoraState(),
            
            const SizedBox(height: 20),

            ElevatedButton(
              onPressed: () {
              },
              style: ElevatedButton.styleFrom(
                foregroundColor: Colors.white,
                backgroundColor: Colors.red, // Cor de fundo do botão
                padding: const EdgeInsets.symmetric(horizontal: 120, vertical: 20),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
                textStyle: const TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  
                ),
              ),
              child: const Text('Bater Ponto'),
            ),
          ],
        ),
      ),
    );
  }
  
  
}


