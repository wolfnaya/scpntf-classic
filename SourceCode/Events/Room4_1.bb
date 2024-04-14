
Function UpdateEvent_Room4_1(e.Events)
	Local n.NPCs
	
	If e\EventState < MilliSecs() Then
		If PlayerRoom <> e\room Then
			If DistanceSquared(EntityX(Collider),EntityX(e\room\obj),EntityZ(Collider),EntityZ(e\room\obj))<PowTwo(16.0) Then
				For n.NPCs = Each NPCs
					If n\NPCtype = NPCtype049 Then
						If n\State = 2 And EntityDistanceSquared(Collider,n\Collider)>PowTwo(16.0) Then
							TFormVector(368, 528, 176, e\room\obj, 0)
							PositionEntity n\Collider, EntityX(e\room\obj)+TFormedX(), TFormedY(), EntityZ(e\room\obj)+TFormedZ()
							DebugLog TFormedX()+", "+ TFormedY()+", "+ TFormedZ()
							ResetEntity n\Collider
							n\PathStatus = 0
							n\State = 4
							n\State2 = 0
							RemoveEvent(e)
						EndIf
						Exit
					EndIf
				Next
			EndIf
		EndIf
		If e<>Null Then e\EventState = MilliSecs()+5000
	EndIf
	
End Function

;~IDEal Editor Parameters:
;~C#Blitz3D