
Player functionality:
Stats
Health: int 100
Speed: int 100
Strength: int 100
Energy: int 100
Can lose health.
Can die.
Should be possible to adjust stats with items, magic buffs, jobs, races
added a spellbook. can add spells and remove spells.
can gain experience and levels
players are considered Creatures

Race functionality
BasePlayer has Set with Races

Profession functionality
Baseplayer has Set with Profession
The doctor profession has a basic self heal. Implemented as something that just does nothing if player isn't a doctor

NPC functionality
Has Health
Can lose health
Can die
Has disposition towards player (Hostile, friendly, neutral)
Can be interacted with (Friendly greets you, neutral ignores you and hostile attacks)
Can offer quests
NPCs are considered Creatures

Quests:
Name
Description
Status 
Mission stages/steps
Reward

Magic functionality:
Consumes energy
deals damage
has magic type (Water, Fire).
has cast call

Map functionality:
based on 2-dimensional array, can return the structure in string format
randomly generated map
randomly generated "noice" (NPCs, equipment)
difficulty dependent on player level
