# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?

I broke down the game into components like locations, artifacts, enemies, and the player. I designed seprate modular classes (Player, Location, Artefacts, and Game). Then, I prioritized implementing the essential mechanics: exploring locations, collecting artifacts, engaging in combat using spells, and monitoring the player's status and health. Next, I created clear and responsive command parsing. This ensured that players could interact with the game world intuitively. Lastly, I tested edge cases like invalid inputs, duplicate artifact collection, and combat without spells. Testing allowed me to refine the mechanics and improve user experience.

 - What **new thing(s)** did you learn / figure out in completing this project?

First, efficient graph representation. By connecting locations as a graph using a HashMap, I learned how to manage interconnected nodes dynamically, making navigation intuitive and scalable. Next is input parsing logic - handling various user commands using a switch statement helped me understand how to parse and process player input effectively without ambiguity. Additionally, I discovered the importance of maintaining game flow and player engagement by balancing difficulty (e.g., forgiving artifact collection and enemy encounters).


 - Is there anything that you wish you had **implemented differently**?

Yes, I would. First of all, I'd have reorganized health and combat mechanics - instead of allowing players to lose health only when spells fail, I could have implemented a real-time timer or immediate consequences for not casting a spell in the first move. This would make combat more challenging and engaging. Second is artifact collection - require players to type the full artifact name (e.g., take Rowena Ravenclaw's diadem) would add realism but may frustrate users. To address this, I could have implemented a partial match system that still verifies accuracy. Last but not least, location descriptions - I wish I had added dynamic descriptions that reflect the presence of enemies or collected artifacts to provide a more immersive experience.

 - If you had **unlimited time**, what additional features would you implement?

1. Dynamic combat system: Enemies could have unique weaknesses that require specific spells.
Introduce dodge mechanics, health potions, and armor to enhance strategy.
2. Randomized events and encounters: I'd add events like traps, hidden treasures, or surprise attacks to make the gameplay less predictable.
3. Graphical interface: I'd replaced the text-based interface with a graphical UI. Locations, player stats, and enemy battles could be displayed visually for a more engaging experience.
4. NPC Interactions: I'd also liked to allow players to interact with characters like Harry, Hermione, or Dumbledore to receive hints, quests, or assistance in battles.
5. Multiple Endings and Side Quests: Introduce branching narratives with choices that impact the story's outcome. Side quests could reward players with spells or health boosts.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

The most helpful feedback came from a classmate (unfortunatel not remeber her name) who suggested making the artifact collection less strict. Initially, I required players to type the full artifact name (e.g., take Rowena Ravenclaw's diadem), which complicated game. The suggestion to simplify artifact collection to take artefact improved the user experience significantly. It ensured players could focus on exploring the game world rather than struggling with inputs.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

1. Begin with fewer interconnected locations and artifacts. Once the mechanics work, scale up the complexity gradually.
2. Plan for edge cases early - design the input parsing and gameplay flow with edge cases (like invalid commands or redundant artifact collection) in mind from the start.
3. Iterate quickly and build a minimal version of the game (basic navigation, artifact collection, and combat) early on. Test it thoroughly and add features incrementally.


 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
