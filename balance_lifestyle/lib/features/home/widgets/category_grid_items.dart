import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/widgets.dart';

class CategoryGridItems extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 8.0),
      child: Row(
        children: [
          Expanded(
            child:Column(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Text(
                  'BALANCE',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 16,
                    letterSpacing: 0.3,
                    fontFamily: 'Georgia',
                    fontWeight: FontWeight.bold,
                    color: AppColors.textPrimary,
                  ),
                ),
                //aqui va lógica de una seccion selecionada(indicador inferior)
              ],
            ),  
          ),
         
          Expanded(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  'GOALS',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 16,
                    letterSpacing: 0.3,
                    fontFamily: 'Georgia',
                    fontWeight: FontWeight.bold,
                    color: AppColors.textPrimary,
                  ),
                ),
              //aqui va lógica de una seccion selecionada(indicador inferior)
              ],
            ),
          ),
          
          Expanded(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  'LIFESTYLE',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 16,
                    letterSpacing: 0.3,
                    fontFamily: 'Georgia',
                    fontWeight: FontWeight.bold,
                    color: AppColors.textPrimary,
                  ),
                ),
                //aqui va lógica de una seccion selecionada(indicador inferior)
              ],
            ),
          ),
          
        ],
      ),
    );
  }
}
