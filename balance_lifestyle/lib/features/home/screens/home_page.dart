import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

@override
  Widget build(BuildContext avatarContext) {
    return const Scaffold(
      body: Center(
        child: Column(
          children: [
            SizedBox(
              height: 20,
              ),
            CircleAvatar(
              radius: 80,
              backgroundImage: AssetImage('assets/user.jpeg'),
            ),
            SizedBox(
              height: 10,
              ),
           
          ],
        ),
        ),
    );
    
  }

 
}
