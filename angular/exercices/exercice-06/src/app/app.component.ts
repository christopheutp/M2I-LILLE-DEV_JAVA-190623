import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exercice-06';
  texts = [
    "Je suis une phrase",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eget nisl nec odio suscipit lacinia. Fusce et mi dictum, consequat tortor vitae, vehicula ligula. Pellentesque.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut id ornare urna. Duis consectetur, velit eu imperdiet elementum, nisi tellus pellentesque eros, vitae consequat leo nibh id dolor. Integer faucibus condimentum quam sed finibus. Fusce auctor fermentum ligula vitae gravida. Nullam dignissim augue auctor arcu malesuada volutpat. Mauris tristique dictum turpis ut finibus. Pellentesque commodo elit non magna aliquam, a molestie purus vulputate. Sed semper ultrices purus. Quisque ornare felis eros, eget gravida dui pharetra eu. Sed vitae massa lectus. In eu faucibus lorem, nec facilisis lorem. Curabitur ut nulla vel turpis convallis placerat sit amet dignissim metus. In eget."
  ]
}
