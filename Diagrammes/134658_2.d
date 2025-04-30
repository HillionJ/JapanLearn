format 224

classcanvas 128002 class_ref 134658 // MainActivity
  classdiagramsettings member_max_width 0 end
  xyz 164.222 399.611 2010
end
classcanvas 128514 class_ref 135170 // TrainActivity
  classdiagramsettings member_max_width 0 end
  xyz 519.889 165.833 2000
end
classcanvas 128642 class_ref 134914 // GuessAnswerData
  classdiagramsettings member_max_width 0 end
  xyz 526.889 610.778 3005
end
classcanvas 129154 class_ref 135042 // SessionState
  classdiagramsettings member_max_width 0 end
  xyz 211.222 721.167 3005
end
classcanvas 129410 class_ref 135298 // Hiraganas
  classdiagramsettings member_max_width 0 end
  xyz 850.611 656.056 3011
end
classcanvas 129794 class_ref 135426 // Kanji
  classdiagramsettings member_max_width 0 end
  xyz 864.222 860.833 3016
end
classcanvas 130050 class_ref 135554 // Katakanas
  classdiagramsettings member_max_width 0 end
  xyz 848.167 769.056 3022
end
classcanvas 130434 class_ref 135682 // SoftKeyboardInput
  classdiagramsettings member_max_width 0 end
  xyz 851.056 42.5 3010
end
classcanvas 130562 class_ref 134786 // AppCompatActivity
  classdiagramsettings member_max_width 0 end
  xyz 524.944 42.6111 3015
end
relationcanvas 128130 relation_ref 134658 // <unidirectional association>
  decenter_begin 32
  decenter_end 170
  from ref 128002 z 2011 to point 134 399
  line 128258 z 2011 to point 134 429
  line 128386 z 2011 to ref 128002
  role_a_pos 104 430 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 128770 relation_ref 134786 // <unidirectional association>
  decenter_begin 804
  decenter_end 39
  from ref 128002 z 3006 stereotype "<<List>>" xyz 412 624 3006 to ref 128642
  role_a_pos 428 603 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 128898 relation_ref 134914 // <unidirectional association>
  decenter_begin 949
  decenter_end 150
  from ref 128002 z 3006 to ref 128642
  role_a_pos 410 644 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129026 relation_ref 135298 // <unidirectional association>
  from ref 128514 z 3006 to ref 128642
  role_a_pos 600 588 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129282 relation_ref 135042 // <unidirectional association>
  from ref 128002 z 3006 to ref 129154
  role_a_pos 268 699 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129538 relation_ref 135426 // <unidirectional association>
  decenter_begin 773
  decenter_end 232
  from ref 129410 z 3012 stereotype "<<List>>" xyz 725 695 3012 to ref 128642
  role_a_pos 664 675 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129666 relation_ref 135554 // <unidirectional association>
  decenter_begin 207
  decenter_end 151
  from ref 129410 z 3012 stereotype "<<List>>" xyz 725 666 3012 to ref 128642
  role_a_pos 664 645 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129922 relation_ref 135682 // <unidirectional association>
  decenter_begin 564
  decenter_end 754
  from ref 129794 z 3017 stereotype "<<List>>" xyz 732 888 3017 to ref 128642
  role_a_pos 664 868 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 130178 relation_ref 135810 // <unidirectional association>
  decenter_begin 828
  decenter_end 546
  from ref 130050 z 3023 stereotype "<<List>>" xyz 724 812 3023 to ref 128642
  role_a_pos 664 791 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 130306 relation_ref 135938 // <unidirectional association>
  decenter_begin 126
  decenter_end 444
  from ref 130050 z 3023 stereotype "<<List>>" xyz 724 774 3023 to ref 128642
  role_a_pos 664 753 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 130690 relation_ref 134530 // <generalisation>
  geometry VHV unfixed
  decenter_end 526
  from ref 128002 z 3016 to point 256 124
  line 130946 z 3016 to point 591 124
  line 131074 z 3016 to ref 130562
  no_role_a no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 130818 relation_ref 135170 // <generalisation>
  decenter_begin 523
  decenter_end 526
  from ref 128514 z 3016 to ref 130562
  no_role_a no_role_b
  no_multiplicity_a no_multiplicity_b
end
end
