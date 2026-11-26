import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class MenuNavegador extends StatelessWidget {
  @override
  Widget build(Object context) {
    return BottomNavigationBar(
      backgroundColor: AppColors.background,
      elevation: 0,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),label: "Home"
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.search),label:"Search"
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.add_box),label: "Add"
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.analytics),label: "Stats"
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),label: "Profile"
          ),
        ], 
        currentIndex: 0,
        selectedItemColor: AppColors.primary,
        unselectedItemColor: AppColors.primaryLight,
        type: BottomNavigationBarType.fixed,
        //aqui ma ir evento de elegir icono  para mostrar su página correspondiente
        onTap: (index) {
        // TODO: Manejar el evento de cambio de página
      },
    );
    
  }
}
